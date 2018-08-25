package com.jp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.util.Status;
import com.jp.util.Timeutil;

@WebServlet("/GetStatusServlet")
public class GetStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetStatusServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("******" + Timeutil.getCurrentTime() + ":获取状态 get******");
		Map<String,String> status = Status.getStatus();
		StringBuilder params = new StringBuilder();
		for(String key:status.keySet()){
			params.append(key+"="+status.get(key)+"&");
			System.out.println(key + ":" +status.get(key));
		}
		if(params.length()!=0){
			String parameter = params.substring(0, params.length()-1);//去掉最后一个&
			response.sendRedirect(request.getContextPath()+"/jsp/cotroller.jsp?"+parameter);
			//request.getRequestDispatcher("/jsp/cotroller.jsp?"+parameter).forward(request, response);
		}else{
			response.sendRedirect(request.getContextPath()+"/jsp/cotroller.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("******获取状态 post******");
		// PrintWriter out = response.getWriter();
		// out.print("doPost method");
	}
}
