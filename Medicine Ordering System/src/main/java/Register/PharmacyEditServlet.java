package Register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

/**
 * Servlet implementation class PharmacyEditServlet
 */
@WebServlet("/PharmacyEditServlet")
public class PharmacyEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// This servlet handles GET requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Staff</h1>");
		// Retrieve the 'id' parameter from the request
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		pharmacy e = Pharmacydao.getEmployeeById(id);
		 // Display a form to edit the staff member's information
		out.print("<form action='PharmacyEditServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + e.getId() + "'/></td></tr>");
		out.print("<tr><td>Frist name:</td><td><input type='text' name='fristname' value='" + e.getFristname()
				+ "'/></td></tr>");
		out.print("<tr><td>Last name:</td><td><input type='text' name='lastname' value='" + e.getLastname()
				+ "'/></td></tr>");
		out.print("<tr><td>Address:</td><td><input type='text' name='nic' value='" + e.getNic() + "'/></td></tr>");

		out.print("<tr><td>City:</td><td><input type='email' name='email' value='" + e.getEmail() + "'/></td></tr>");
		out.print("<tr><td>password:</td><td><input type='password' name='password' value='" + e.getPassword()
				+ "'/></td></tr>");
		out.print("<tr><td>repassword:</td><td><input type='password' name='repassword' value='" + e.getRepassword()
				+ "'/></td></tr>");

		out.print("<tr><td>Phone:</td><td><input type='tel' name='phone' value='" + e.getPhone() + "'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='date' name='dob' value='" + e.getDob() + "'/></td></tr>");

		out.print("<tr><td>Country:</td><td>");
		out.print("<select name='country' style='width:150px'>");
		out.print("<option>sri lanak</option>");
		out.print("<option>usa</option>");
		out.print("<option>uk</option>");
		out.print("</select>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");

		out.close();
	}
}



