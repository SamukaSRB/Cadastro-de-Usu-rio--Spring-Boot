package com.webapp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




/*
Aqui o controlador para o UsuarioController ele que vai fazer a ação do mvc
Criou um classe UserController adicionamos a annotation @Controller,o @AutoWired e por fim um metodo privado chamado 
UserService que vai importar a classe servide de UserService,depois usamos o @GetMapping para criar rotas para users
Criamos um metodo do tipo String que vai exibir os dados da classe modelo que vai criar posteriormente um array list
juntamento com um objeto pegando todos os dados depois setamos e uma variavel que vai ser usada na pagina html e o seu retorno a view "users"
 */

@Controller
public class UserController {
	@Autowired 
	private UserService service;
	@GetMapping("/users")
	public String showUserList(Model model) {
		List<User> ListUsers = service.listAll();
		model.addAttribute("ListUsers",ListUsers);
	return "users";
	}
	
//	Este metodo so serve para retornar o formulario de adição 
	@GetMapping("/users/new")
	public String showNewForm(Model model) {
		model.addAttribute("user",new User());
		model.addAttribute("page title", "Add New User");
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user, RedirectAttributes ra){	
		service.save(user);	
		ra.addFlashAttribute("message", "O item foi alterado com sucesso");
		return "redirect:/users/";
		
	}
	@GetMapping("/users/edit/{id}")
	public String showEditForm(@PathVariable("id")Integer id, Model model, RedirectAttributes ra) {
		try {
		User user =	service.get(id);
		model.addAttribute("user", user);
		model.addAttribute("pageTitle", "Edit User(ID:" + id + ")");
		return "user_form";
		}catch (UserNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
			return "redirect:/users/";	
		}
		
	}
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id")Integer id, Model model, RedirectAttributes ra) {
		try {
			service.delete(id);
			ra.addFlashAttribute("message","O usuario " + id + "deletado com sucesso");
		}catch (UserNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());			
		}
		return "redirect:/users/";
		
	}
	
	

}
