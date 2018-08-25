package com.jp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.util.Status;
import com.jp.util.Timeutil;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("******" + Timeutil.getCurrentTime() + ":控制 get******");
		PrintWriter out = response.getWriter();
		String[] led = request.getParameterValues("led");//获取到的为选中，没获取到的为未选中！！！！！
		String source = request.getParameter("source");//获取到的为选中，没获取到的为未选中！！！！！
		boolean b1 = false;
		boolean b2 = false;
		boolean s1 = false;
		if(led!=null){
			for(String l:led){
				if(l.equals("led1"))
					b1=true;
				else if(l.equals("led2"))
					b2=true;
			}
		}
		if(source!=null){
			s1 = true;
		}
		if(b1)
			Status.setStatus("led1", "on");
		else
			Status.setStatus("led1", "off");
		if(b2)
			Status.setStatus("led2", "on");
		else
			Status.setStatus("led2", "off");
		if(s1)
			Status.setStatus("source", "on");
		else
			Status.setStatus("source", "off");
		response.sendRedirect(request.getContextPath()+"/servlet/GetStatusServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("******控制 post******");
	}


}
