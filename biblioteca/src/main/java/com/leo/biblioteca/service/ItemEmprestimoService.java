package com.leo.biblioteca.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.biblioteca.dto.itememprestimo.ItemEmprestimoRequest;
import com.leo.biblioteca.dto.itememprestimo.ItemEmprestimoResponse;
import com.leo.biblioteca.entity.EmprestimoEntity;
import com.leo.biblioteca.entity.ItemEmprestimo;
import com.leo.biblioteca.repository.ItemEmprestimoRepository;

@Service
public class ItemEmprestimoService {
    @Autowired
    private ItemEmprestimoRepository itemEmprestimoDAO;

    public List<ItemEmprestimo> listarItensEmprestimo() {
        return itemEmprestimoDAO.findAll();
    }

    public ItemEmprestimo cadastrarItemEmprestimo(ItemEmprestimo itemEmprestimo) {
        return itemEmprestimoDAO.save(itemEmprestimo);
    }

    public List<ItemEmprestimo> verificarLivros(List<ItemEmprestimoRequest> itemEmprestimoRequest) {
        List<ItemEmprestimo> itensEmprestimo = new ArrayList<>();
        for (ItemEmprestimoRequest itemEmprestimo : itemEmprestimoRequest) {
            ItemEmprestimo item = new ItemEmprestimo();
            item.setDataPrevista(calculaDataDevolucaoItem(new Date(), itemEmprestimo.livro().getTitulo().getPrazo()));
            item.setLivro(itemEmprestimo.livro());
            item.setEmprestimo(null);
            itensEmprestimo.add(item);

        }
        return itensEmprestimo;
    }

    public List<ItemEmprestimoResponse> cadastrarListaItensEmprestimo(List<ItemEmprestimo> itensEmprestimo, EmprestimoEntity emprestimo) {
        List<ItemEmprestimoResponse> response = new ArrayList<>();
        for (ItemEmprestimo item : itensEmprestimo) {
            cadastrarItemEmprestimo(item);
            response.add(new ItemEmprestimoResponse(
                    item.getId(),
                    item.getDataPrevista(),
                    item.getLivro()
            ));
        }
        return response;
    }

    public Date calculaDataDevolucaoItem(Date data, int prazo)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.DATE, prazo);
        return calendar.getTime();
    }
}
