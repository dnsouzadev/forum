package com.dnsouzadev.forum.controller

import com.dnsouzadev.forum.dto.NovoTopicoForm
import com.dnsouzadev.forum.dto.TopicoView
import com.dnsouzadev.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {


    @GetMapping
    fun lista(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        println("Buscando por id: $id")
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm) {
        service.cadastrar(dto);
    }
}