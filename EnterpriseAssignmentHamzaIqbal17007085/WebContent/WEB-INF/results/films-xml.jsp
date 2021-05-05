<%@ page import = "java.util.List" %>
<%@ page import = "javax.xml.bind.JAXBContext" %>
<%@ page import ="javax.xml.bind.JAXBException" %>
<%@ page import ="javax.xml.bind.Marshaller" %>
<%@ page import ="model.FilmList" %>
<%@ page import ="model.Film" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%
//ArrayList<Film> films = //(ArrayList<Film>) request.getAttribute("films");

FilmList films = new FilmList((List<Film>) request.getAttribute("films"));
try {
	// create JAXB context and instantiate marshaller
    JAXBContext context = JAXBContext.newInstance(FilmList.class);
	Marshaller m = context.createMarshaller();
   // m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    // Send to client
    m.marshal(films, out);
} catch (JAXBException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

%>
