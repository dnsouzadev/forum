package com.dnsouzadev.forum.service

import com.dnsouzadev.forum.model.Curso
import com.dnsouzadev.forum.model.Topico
import com.dnsouzadev.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topicos1 = Topico(
                id = 1,
                titulo = "Duvida",
                mensagem = "Duvida com Spring",
                curso = Curso(
                    id = 1,
                    nome = "Spring Boot",
                    categoria = "Programacao"
                ),
                autor = Usuario(
                    id = 1,
                    nome = "Douglas",
                    email = "douglas@gmail.com"
                )
            )
        val topicos2 = Topico(
                id = 2,
                titulo = "Duvida",
                mensagem = "Duvida com Kotlin",
                curso = Curso(
                    id = 1,
                    nome = "Spring Boot",
                    categoria = "Programacao"
                ),
                autor = Usuario(
                    id = 1,
                    nome = "Douglas",
                    email = "douglas@gmail.com"
                )
            )
        topicos = listOf(topicos1, topicos2)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter { t -> t.id == id }.findFirst().get()
    }
}
