let temaIndex = 0;

function agregarTema() {
    const contenedor = document.getElementById("temasContainer");

    const temaHTML = `
        <div class="tema-item" data-index="${temaIndex}">
            <div class="input-flex">
                <div>
                    <input type="text" class="form-input nombreTema" placeholder="Ej. Variables" required />
                    <label class="form-label">Nombre del tema</label>
                </div>
            </div>
            <div class="textarea">
                <textarea rows="3" class="form-input descripcionTema" placeholder="Descripción del tema..." required></textarea>
                <label class="form-label">Descripción</label>
            </div>
            <hr>
        </div>
    `;

    contenedor.insertAdjacentHTML("beforeend", temaHTML);
    temaIndex++;
}

document.getElementById("cursoForm").addEventListener("submit", async function (e) {
    e.preventDefault();

    const nombre = document.getElementById("nombreCurso").value;
    const modalidad = document.getElementById("modalidadCurso").value;
    const fecha = document.getElementById("fechaCurso").value;

    const temas = [];
    const temasDiv = document.querySelectorAll(".tema-item");

    temasDiv.forEach(div => {
        const nombre = div.querySelector(".nombreTema").value;
        const descripcion = div.querySelector(".descripcionTema").value;
        temas.push({ nombre, descripcion });
    });

    const curso = {
        nombre,
        modalidad,
        fecha_finalizacion: fecha,
        listaDeTemas: temas
    };

    const respuesta = await fetch("http://localhost:8080/cursos/crear", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(curso)
    });

    const mensaje = document.getElementById("mensaje");

    if (respuesta.ok) {
        mensaje.innerText = "Curso guardado correctamente.";
        mensaje.style.color = "green";
        document.getElementById("cursoForm").reset();
        document.getElementById("temasContainer").innerHTML = "";
    } else {
        mensaje.innerText = "Error al guardar el curso.";
        mensaje.style.color = "red";
    }
});
