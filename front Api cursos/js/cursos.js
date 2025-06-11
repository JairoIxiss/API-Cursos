window.onload = () => {
    cargarCursos();
};

const cargarCursos = async () => {
    const res = await fetch("http://localhost:8080/cursos/traer");
    const cursos = await res.json();

    let tablaBody = "";
    for (let curso of cursos) {
        let temasNombres = curso.listaDeTemas.map(t => t.nombre).join(", ");
        tablaBody += `
            <tr>
                <td>${curso.id_curso}</td>
                <td>${curso.nombre}</td>
                <td>${curso.modalidad}</td>
                <td>${curso.fecha_finalizacion}</td>
                <td>${temasNombres}</td>
                <td>
                    <i class="material-symbols-outlined edit" onclick='abrirEdicion(${JSON.stringify(curso)})'>edit</i>
                    <i class="material-symbols-outlined delete" onclick='eliminarCurso(${curso.id_curso})'>delete</i>
                </td>
            </tr>
        `;
    }
    document.querySelector("#tablaCursos tbody").innerHTML = tablaBody;
};

const eliminarCurso = async (id) => {
    await fetch(`http://localhost:8080/cursos/eliminar/${id}`, {
        method: "DELETE"
    });
    cargarCursos();
};

const abrirEdicion = (curso) => {
    document.getElementById("modal").style.display = "block";
    document.getElementById("editId").value = curso.id_curso;
    document.getElementById("editNombre").value = curso.nombre;
    document.getElementById("editModalidad").value = curso.modalidad;
    document.getElementById("editFecha").value = curso.fecha_finalizacion;

    const temasDiv = document.getElementById("editTemas");
    temasDiv.innerHTML = "";

    curso.listaDeTemas.forEach((tema, index) => {
        temasDiv.innerHTML += `
            <div>
                <input type="text" class="form-input temaNombre" value="${tema.nombre}" placeholder="Nombre del tema">
                <input type="text" class="form-input temaDesc" value="${tema.descripcion}" placeholder="Descripción">
            </div>
        `;
    });
};

const cerrarModal = () => {
    document.getElementById("modal").style.display = "none";
};

const guardarEdicion = async () => {
    const id = document.getElementById("editId").value;
    const nombre = document.getElementById("editNombre").value;
    const modalidad = document.getElementById("editModalidad").value;
    const fecha = document.getElementById("editFecha").value;

    const temas = [];
    document.querySelectorAll("#editTemas div").forEach(div => {
        const nombre = div.querySelector(".temaNombre").value;
        const descripcion = div.querySelector(".temaDesc").value;
        temas.push({ nombre, descripcion });
    });

    const cursoEditado = {
        id_curso: id,
        nombre,
        modalidad,
        fecha_finalizacion: fecha,
        listaDeTemas: temas
    };

    await fetch(`http://localhost:8080/cursos/editar/${id}`, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(cursoEditado)
    });

    cerrarModal();
    cargarCursos();
};
