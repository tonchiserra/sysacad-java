class AdminMenu extends HTMLElement {
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
					<li><a href="./abmc-carrera.jsp">ABMC Carrera</a></li>
					<li><a href="./abmc-comision.jsp">ABMC Comisión</a></li>
					<li><a href="./abmc-materia.jsp">ABMC Materia</a></li>
					<li><a href="../LogoutServlet">Salir</a></li>
				</ul>
			</nav>
		`
	}
}

customElements.define('admin-menu', AdminMenu)