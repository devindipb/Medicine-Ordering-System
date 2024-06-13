package Register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PharmacyEditServlet2
 */
@WebServlet("/PharmacyEditServlet2")
public class PharmacyEditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String fristname = request.getParameter("fristname");
		String lastname = request.getParameter("lastname");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String country = request.getParameter("country");

	   pharmacy e = new pharmacy();
		e.setId(id);
		e.setFristname(fristname);
		e.setLastname(lastname);
		e.setNic(nic);
		e.setEmail(email);
		e.setPassword(password);
		e.setRepassword(repassword);
		e.setPhone(phone);
		e.setDob(dob);
		e.setCountry(country);

		int status = Pharmacydao.update(e);
		if (status > 0) {
			response.sendRedirect("PharmacyViewServlet");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
