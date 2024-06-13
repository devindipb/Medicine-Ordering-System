package Register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class PharmacyViewServlet
 */
@WebServlet("/PharmacyViewServlet")
public class PharmacyViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	// This servlet handles GET requests
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<title>Staff List</title>");
		out.println("<a href='home.html'>home</a>");
		out.println("<h1>Registered Pharmacy List</h1>");

		List<pharmacy> list = Pharmacydao.getAllEmployees();
		// Display a table to show the list of pharmacy staff members
		out.print("<table border='2' style='font-family: arial, sans-serif;\r\n" + "  border-collapse: collapse;\r\n"
				+ "  width: 100%;' ");
		out.print(
				"<tr><th>Id</th><th>Frist Name</th><th>Last name</th><th>NIC</th><th>Email</th><th>Password</th><th>Repassword</th><th>Phone</th><th>DOB</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for (pharmacy e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getFristname() + "</td><td>" + e.getLastname()
					+ "</td><td>" + e.getNic() + "</td><td>" + e.getEmail() + "</td><td>" + e.getPassword()
					+ "</td><td>" + e.getRepassword() + "</td><td>" + e.getPhone() + "</td><td>" + e.getDob()
					+ "</td><td>" + e.getCountry() + "</td><td><a href='PharmacyEditServlet?id=" + e.getId()
					+ "'>edit</a></td><td><a href='PharmacyDeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
		}
		out.print("</table>");

		out.close();
	}
}