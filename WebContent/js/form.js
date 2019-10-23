window.onload = function(){
    formBasicFunctions();
    formCreate();
    formLogin();
}

function formBasicFunctions(){
	new_account = document.querySelector("#new_account");
	if(new_account != null){
		new_account.addEventListener("click", function(e){
        	window.top.location.href="account.html";
    	});
	}

    /*var toggle_activate = document.querySelectorAll("#toggle_activate_1, #toggle_activate_2");
    if(toggle_activate[0] != undefined && toggle_activate[1] != undefined){
	    toggle_activate[0].addEventListener("click", function(e){
	    	toggleForms()
	    });    
	    toggle_activate[1].addEventListener("click", function(e){
	    	toggleForms()
	    });  	
    }*/
}

function formLogin(){
    var login_account = document.querySelector("#form-acessar");
	if(login_account != null){
		login_account.addEventListener("submit", function(e){
			e.preventDefault();
			var email = document.querySelector("#user").value;
			var senha = document.querySelector("#pass").value;
			console.log(email, senha);

        	window.top.location.href="algoritimos.html";
	    });  
	}
}

function formCreate(){
    var login_account = document.querySelector("#form-registrar");
	if(login_account != null){
		login_account.addEventListener("submit", function(e){
			e.preventDefault();
			var nome = document.querySelector("#name").value;	
			var rm = document.querySelector("#rm").value;	

			var email = document.querySelector("#email").value;			
			var email_confirm = document.querySelector("#email_confirm").value;
			if(email != email_confirm){
				alert("Email's não coincidem.");
				return
			}

			var senha = document.querySelector("#senha").value;
			var senha_confirm = document.querySelector("#senha_confirm").value;
			if(senha != senha_confirm){
				alert("As senhas não coincidem.");
				return
			}

			alert("Cadastrado com sucesso.");
			console.log(nome, rm, email, senha);
			toggleForms()			
	    });  
	}
}

function toggleForms(){
	var create_account = document.querySelector("#form-registrar");
	var login_account = document.querySelector("#form-acessar");
	create_account.classList.toggle("activate");
	login_account.classList.toggle("activate");
}

var formulario = document.querySelector('form');

formulario.onsubmit = function(){
   if(!document.querySelector("input[type='text']").value){
       alert("Campo vazio!");
   } 
	  else {
		//alert("Conta criada com sucesso.");
		window.location = 'cursos.html';
   }
}