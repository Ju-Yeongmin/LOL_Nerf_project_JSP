package hae.nerf.lol;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.hae")
public class NerfFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" \n\nNerfFrontController 호출!\n ");
		
		// 1. 가상주소 계산 시작
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		String command = requestURI.substring(contextPath.length());
		System.out.println(" C : command : " + command);
		System.out.println(" C : 가상주소 계산 끝!\n ");
		// 1. 가상주소 계산 끝
		
		
		// 2. 가상주소 매핑 시작
		ActionForward forward = null;
		Action action = null;
		
		if (command.equals("/Nerf.hae")) {
			System.out.println(" C : /Nerf.hae 호출 ");
			System.out.println(" C : 패턴3 ");
			
			// NerfAction() 객체 생성
			action = new NerfAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (command.equals("/ChampionInfo.hae")) {
			System.out.println(" C : /ChampionInfo.hae 호출 ");
			System.out.println(" C : 패턴3 ");
			
			// ChampionInfoAction 객체
			action = new ChampionInfoAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/FightRecord.hae")) {
			System.out.println(" C : /FightRecord.hae 호");
			System.out.println(" C : 패턴3 ");
			
			// FightRecordAction
			action = new FightRecordAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (command.equals("/ChampionUpdate.hae")) {
			System.out.println(" C : /ChampionUpdate.hae 호출 ");
			System.out.println(" C : 패턴2 ");
			
			// ChampionUpdateAction
			action = new ChampionInfoAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println(" C : 가상주소 매핑 끝!\n ");
		// 2. 가상주소 매핑 끝
		
		
		
		// 3. 페이지 이동 시작
		if (forward != null) {
			if (forward.isRedirect()) { // isRedirect가 true => redirect로 이동
				response.sendRedirect(forward.getPath());
				
				System.out.println(" C : redirect 로 이동! : " + forward.getPath());
			} else { // 아니면 forward로 이동
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
				
				System.out.println(" C : forwarding 으로 이동! : " + forward.getPath());
			}
		}
		
		System.out.println(" C : 페이지 이동 끝!\n ");
		// 3. 페이지 이동 끝
		
		
		
	}
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	
	
}
