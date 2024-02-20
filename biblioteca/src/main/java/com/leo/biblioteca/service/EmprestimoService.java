package com.leo.biblioteca.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.biblioteca.entity.AlunoEntity;
import com.leo.biblioteca.entity.DebitoEntity;
import com.leo.biblioteca.entity.EmprestimoEntity;
import com.leo.biblioteca.entity.ItemEmprestimo;
import com.leo.biblioteca.repository.EmprestimoRepository;
import com.leo.biblioteca.dto.emprestimo.EmprestimoRequestDTO;
import com.leo.biblioteca.dto.emprestimo.EmprestimoResponse;
import com.leo.biblioteca.dto.itememprestimo.ItemEmprestimoResponse;

@Service
public class EmprestimoService {
    @Autowired
    private EmprestimoRepository emprestimoDAO;

    @Autowired
    private ItemEmprestimoService itemEmprestimoService;

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private DebitoService debitoService;


    public List<EmprestimoEntity> listarEmprestimos() {
        return emprestimoDAO.mostrarTodos();
    }

    public EmprestimoResponse  cadastrarEmprestimo(EmprestimoRequestDTO emprestimoRequest) {

        AlunoEntity aluno = alunoService.listarPorId(emprestimoRequest.alunoMatricula());
        
        List<ItemEmprestimo> itensEmprestimo = itemEmprestimoService.verificarLivros(emprestimoRequest.itensEmprestimo());

        
        EmprestimoEntity emprestimo = new EmprestimoEntity();
        emprestimo.setDevolucao(null);
        emprestimo.setAluno(aluno);

        emprestimoDAO.salvarEmprestimo(emprestimo);

        List<ItemEmprestimoResponse> itensEmprestimoResponse = itemEmprestimoService.cadastrarListaItensEmprestimo(itensEmprestimo, emprestimo);

        return new EmprestimoResponse(
                emprestimo.getId(),
                emprestimo.getDataEmprestimo(),
                emprestimo.getAluno(),
                emprestimo.getDevolucao(),
                itensEmprestimoResponse
        );
    }

    private Date CalculaDataPrevista(List<ItemEmprestimo> itens)
    {
        Date dataAux;
        Date dataPrevista = new Date();

        for (ItemEmprestimo item : itens) {
            dataAux = item.getDataPrevista();
            if (dataPrevista.compareTo(dataAux) < 0)
                dataPrevista = dataAux;
        }
        if (itens.size() > 2) {
            int tam = itens.size()-2;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataPrevista);
            calendar.add(Calendar.DATE, (tam*2));
            dataPrevista = calendar.getTime();
        }
        for (ItemEmprestimo item : itens) {
            item.setDataPrevista(dataPrevista);
        }

        return dataPrevista;

    }
}
