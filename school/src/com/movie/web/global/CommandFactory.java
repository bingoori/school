package com.movie.web.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandFactory {
	// member/login_form.do?id=hong&password=1
	public static Command getCommand(HttpServletRequest request, HttpServletResponse response) {
		String[] arr = new String[2];
		String path = request.getServletPath();
		String queryString = " ";

		arr[0] = path.split("/")[1];
		arr[1] = path.split("/")[2].split("[.]")[0];

		return new Command(arr[0], arr[1]);
	}

	public static Command createCommand(String directory, String action) {
		return new Command(directory, action);
	}
}
