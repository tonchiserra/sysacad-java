class LoginForm extends HTMLElement {
	constructor() {
		super()
		this.init()
	}
	
	init() {
		this.inputLegajo = this.querySelector('input[type="text"]')
		this.inputLegajo.addEventListener("keyup", e => this.legajoHandler(e))
		this.inputPassword = this.querySelector('input[type="password"]')
		this.inputPassword.addEventListener("keyup", e => this.passwordHandler(e))
	}
	
	legajoHandler(e) {
		if(!e.target.value.match(/^[0-9]/)) {
			this.inputLegajo.style.border = '1px solid #ff0000'
			if(e.target.value.length > 0) {
				this.querySelector('.legajo__error-message').innerHTML = 'El legajo debe contener solo números'	
			}else {
				this.querySelector('.legajo__error-message').innerHTML = 'Este campo no puede estar vacío'
			}
		}else {
			this.inputLegajo.style.border = 'none'
			this.querySelector('.legajo__error-message').innerHTML = ''
		}
	}
	
	PasswordHandler(e) {
		
	}
}

customElements.define('login-form', LoginForm)