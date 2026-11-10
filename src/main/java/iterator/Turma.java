package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Turma implements Iterable<Aluno> {

    private final List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public Iterator<Aluno> iterator() {
        return new TurmaIterator(alunos);
    }
}
