package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Date date = new Date();	//실행 시점의 일시
		String current = String.format("%tY-%<tm-%<td %<tH:%<tM:%<tS", date); //jdk1.5이상부터 가능
		
		//SimpleDateFormat : java.util.Date <==> String (-> : format(), <- : parse())
		//yyyy : 년도 (4자리), MM : 월 (2자리), dd : 일 (2자리), HH : 시간 (24시간제-2자리), mm : 분 (2자리), ss : 초 (2자리)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current2 = sdf.format(date);
		//Date dd = sdf.parse("2011-11-20 23:22:05");
		
		response.setContentType("text/html;charset=UTF-8"); //=앞뒤에 공백 넣으면 안됨
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head><title>현재 시간</title></head>");
		out.println("<body>");
		out.printf("현재 시간1 : %s<br>", current);
		out.printf("현재 시간2 : %s<br>", current2);
		out.println("</body></html>");
		
		
		
		
	}
}
