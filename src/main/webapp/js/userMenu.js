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
					<li><a href="./ListaMaterias.jsp">Estado académico</a></li>
					<li><a href="./inscripcionExamen.jsp">Inscripción a exámen</a></li>
					<li><a href="../LogoutServlet">Salir</a></li>
				</ul>
			</nav>
		`
	}
}

customElements.define('user-menu', UserMenu)