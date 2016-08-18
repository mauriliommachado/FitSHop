/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import control.ControleEmpresa;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import model.Empresa;

/**
 * REST Web Service
 *
 * @author Maurílio
 */
@Path("ServiceEmpresa")
public class ServiceEmpresa {

    @Context
    private UriInfo context;
    private Gson gson = new Gson();

    public ServiceEmpresa() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getText() {
        return "Hello";
    }

    @GET
    @Path("busca/{idEmpresa}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmpresa(@PathParam("idEmpresa") int id) {
        Empresa empresa = ControleEmpresa.busca(id);
        if (empresa != null) {
            ControleEmpresa.limpaEmpresa(empresa);
        }
        return gson.toJson(empresa != null ? empresa : false);
    }

    @GET
    @Path("busca")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmpresas() {
        List<Empresa> listaEmpresa = ControleEmpresa.busca();
        return gson.toJson(ControleEmpresa.limpaEmpresa(listaEmpresa));
    }

    @PUT
    @Path("grava")
    @Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
    public String putEmpresa(String content) {
        Empresa empresa;
        int cod;
        if (content.isEmpty()) {
            return null;
        }
        try {
            empresa = gson.fromJson(content, Empresa.class);
        } catch (JsonSyntaxException ex) {
            System.out.println(ex);
            return null;
        }
        if (empresa.getCodEmpresa() == null) {
            cod = ControleEmpresa.gravar(0, empresa.getEmpCNPJ());
        } else {
            cod = ControleEmpresa.gravar(empresa.getCodEmpresa(), empresa.getEmpCNPJ());
        }
        return gson.toJson(ControleEmpresa.limpaEmpresa(ControleEmpresa.busca(cod)));
    }

    @GET
    @Path("delete/{idEmpresa}")
    public String deleta(@PathParam("idEmpresa") int id) {
        if (ControleEmpresa.deleta(id)) {
            return gson.toJson(true);
        }
        return gson.toJson(false);

    }
}
