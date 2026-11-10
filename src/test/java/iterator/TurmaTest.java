package iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TurmaTest {

    @Test
    void devePercorrerAlunosNaOrdemDeCadastro() {
        Turma turma = new Turma();
        turma.adicionarAluno(new Aluno("Ana"));
        turma.adicionarAluno(new Aluno("Pedro"));

        List<String> nomes = new ArrayList<>();
        for (Aluno aluno : turma) {
            nomes.add(aluno.getNome());
        }

        assertEquals(List.of("Ana", "Pedro"), nomes);
    }

    @Test
    void naoDeveTerProximoEmTurmaVazia() {
        Turma turma = new Turma();

        assertFalse(turma.iterator().hasNext());
    }

    @Test
    void deveLancarExcecaoAoUltrapassarUltimoAluno() {
        Turma turma = new Turma();
        turma.adicionarAluno(new Aluno("Ana"));
        Iterator<Aluno> iterator = turma.iterator();

        assertTrue(iterator.hasNext());
        iterator.next();

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void deveManterPosicaoIndependenteParaCadaIterator() {
        Turma turma = new Turma();
        turma.adicionarAluno(new Aluno("Ana"));
        turma.adicionarAluno(new Aluno("Pedro"));
        Iterator<Aluno> primeiro = turma.iterator();
        Iterator<Aluno> segundo = turma.iterator();

        assertEquals("Ana", primeiro.next().getNome());
        assertEquals("Pedro", primeiro.next().getNome());
        assertEquals("Ana", segundo.next().getNome());
    }
}
