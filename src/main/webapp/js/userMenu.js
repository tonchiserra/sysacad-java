class UserMenu extends HTMLElement {
	constructor() {
		super()
		this.init()
	}
	
	init() {
		this.classList.add("main-menu")
		this.innerHTML = `
			<nav>
				<ul>
					<li><a href="./index.jsp">Página principal</a></li>
					<li><a href="">Materias del plan</a></li>
					<li><a href="./ListaMaterias.jsp">Estado académico</a></li>
					<li><a href="">Exámenes</a></li>
					<li><a href="">Cursado</a></li>
					<li><a href="">Correlatividades</a></li>
					<li><a href="./inscripcionExamen.jsp">Inscripción a exámen</a></li>
					<li><a href="">Inscripción a cursado</a></li>
					<li><a href="">Cambio de contraseña</a></li>
					<li><a href="../LogoutServlet">Salir</a></li>
				</ul>
			</nav>
		`
	}
}

customElements.define('user-menu', UserMenu)