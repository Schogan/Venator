package Venator.Venator.controller;

import Venator.Venator.service.GetIdsByName;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PostController extends HttpServlet {

  @Autowired private GetIdsByName getIdsByName;

  @RequestMapping(value="/getIdsByNamePost", method= RequestMethod.GET)
  public ModelAndView getIdsByName() throws IOException {
    System.out.println("made it here");

    ModelAndView model = new ModelAndView("testModel");

    String results = getIdsByName.getIdsByName();

    return model;

  }
}
