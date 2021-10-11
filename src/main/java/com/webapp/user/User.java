package com.webapp.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/*
 Esta parte consiste de uma classe modelo que vai intanciar um modelagem na base de dados.
 Criamos o modelo onde definimos o hibernate que vai ser usando com anotation @Entity pois o entity cria as tabelas no banco atumaticamente baseada na classe modelo.
 Colocamos o nome da tabela a ser criada @Table users, e partimos para construção do atributoas da classe juntamente com os get e setters.
 Definimos um anotation @Id que vai indicar para tabela que vai ser um identificador único depois @GeneratedValue que vai ser auto incrementado.
 Para as colunas definimos um anotation @Column onde especificamos as propriedadades tais como tamanho da string se vai aceitar dados nulos etc...
 E por fim criamos um  metodo override que vai ser responsavel para sobrepor o metodos ja criado do tipo string.
*/
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  Integer id;
	
	@Column(nullable=false, unique=true, length=45)
	private String email;
	
	@Column(length = 15 ,nullable=false )
	private String password;
	
	@Column(length = 45 ,nullable=false, name="first_name")
	private String firstName;
	
	@Column(length = 45 ,nullable=false, name="last_name")
	private String lastName;
	
	private boolean enabled;
	
	//Get e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}



	
	
	
	
	
	
	
	

	
}
