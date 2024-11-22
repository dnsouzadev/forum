package com.dnsouzadev.forum.mapper

import com.dnsouzadev.forum.dto.NovoTopicoForm
import com.dnsouzadev.forum.model.Topico
import com.dnsouzadev.forum.service.CursoService
import com.dnsouzadev.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}
