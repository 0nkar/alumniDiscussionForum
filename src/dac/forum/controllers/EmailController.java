package dac.forum.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dac.forum.pojos.Login;
@Controller

public class EmailController {
@Autowired
private JavaMailSender mailSender;
//@RequestMapping(method = RequestMethod.POST)

@RequestMapping("/showEmail")
public ModelAndView showLogin(HttpSession session) {
	ModelAndView mav;
	Login command = new Login();
	String Userprn= (String) session.getAttribute("prn") ;
	 if (Userprn!=null)
	 {
	mav = new ModelAndView("t_showemaill", "command", command);
	return mav;
	 }
	 else
	 {
		 mav = new ModelAndView("t_showemail", "command", command);
			return mav;
	 }
}




@RequestMapping("/sendEmail")
public String doSendEmail(HttpServletRequest request) 
				{
							// takes input from e-mail form
							String recipientAddress = request.getParameter("recipient");
							String subject = request.getParameter("subject");
							String message = request.getParameter("message");
							// prints debug info
							System.out.println("To: " + recipientAddress);
							System.out.println("Subject: " + subject);
							System.out.println("Message: " + message);
							// creates a simple e-mail object
							SimpleMailMessage email = new SimpleMailMessage();
							email.setTo(recipientAddress);
							email.setSubject(subject);
							email.setText(message);
							// sends the e-mail
							System.out.println("Email Controller");
							mailSender.send(email);
							// forwards to the view named "Result"
							System.out.println("Email Controller");
							return "t_email";
				}
}