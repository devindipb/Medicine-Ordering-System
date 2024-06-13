package Register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class pharmacySaveServlet
 */
@WebServlet("/pharmacySaveServlet")
public class pharmacySaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 // Retrieve data from the HTML form 
		String fristname = request.getParameter("fristname");
		String lastname = request.getParameter("lastname");
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String phone = request.getParameter("phone");
		String dob = request.getParameter("dob");
		String country = request.getParameter("country");

		 // Create an instance of the 'pharmacy' class 
		pharmacy e = new pharmacy();
		// Set the retrieved data in the 'pharmacy' object
		e.setFristname(fristname);
		e.setLastname(lastname);
		e.setNic(nic);
		e.setEmail(email);
		e.setPassword(password);
		e.setRepassword(repassword);
		e.setPhone(phone);
		e.setDob(dob);
		e.setCountry(country);
		 // Call the 'save' method of the 'Pharmacydao' class to save the data to the database
		int status = Pharmacydao.save(e);
		if (status > 0) {
			response.sendRedirect("PharmacyViewServlet");
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("regdeliverystaff.html").include(request, response);
		} else {
			out.println("Sorry! unable to save record");
		}
		// Close the response stream.
		out.close();
	}

}
