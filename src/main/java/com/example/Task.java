package com.example;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Task extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(Task.class.getName());

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String taskName = req.getHeader("X-AppEngine-TaskName");
		
		long start = System.currentTimeMillis();
		log.info("Start Task - "+taskName);
		
		try { // sleep up to 3 min 15s
			Thread.sleep((int) Math.pow(new Random().nextInt(56), 3)); // pow to have bigger variation
		} catch (InterruptedException e) {}
		
		log.info("End Task - "+taskName+" - duration="+(System.currentTimeMillis()-start)+"ms");
		
		resp.setStatus(200);
	}
}
