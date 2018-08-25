package com.jp.servlet;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jp.util.Status;
import com.jp.util.Timeutil;


/**
 * 下位机一直保持请求
 * 
 * @author Administrator
 *
 */
@WebServlet("/AskServlet")
public class AskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AskServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println("******" + Timeutil.getCurrentTime() + ":询问请求 get******");
		PrintWriter out = response.getWriter();
		String reqParm = request.getParameter("Hello");
		if(reqParm!=null){
			try {
				System.out.println("Params方式请求!");
				System.out.println("请求参数" + reqParm );
				out.print("请求参数为：" + reqParm);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
		
		String reqMessage = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			reqMessage = sb.toString();
			System.out.println("RequertParameter:" + reqMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果请求开门
		if (reqMessage.equals("Hello")) {
			//开门状态为真
//			if (OpenDoorUtil.openDoorState) {
//				out.print("open");
//				System.out.println("******开门!******");
//			} else {
//				System.out.println("******拒绝!******");
//				out.print("error");
//			}
			out.print("Hi HuXin");
		} else if(reqMessage.equals("status")){
			System.out.println("获取状态");
			Map<String,String> status = Status.getStatus();
			StringBuilder params = new StringBuilder();
			for(String key:status.keySet()){
				params.append(key+"="+status.get(key)+"&");
			}
			String parameter = params.substring(0, params.length()-1);
			System.out.println(parameter);
			out.print(parameter);
		}else {
			out.print("Error HuXin");
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("******询问请求 post******");
		// PrintWriter out = response.getWriter();
		// out.print("doPost method");
	}


}
