package iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TurmaIterator implements Iterator<Aluno> {

    private final List<Aluno> alunos;
    private int posicao;

    public TurmaIterator(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public boolean hasNext() {
        return posicao < alunos.size();
    }

    @Override
    public Aluno next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return alunos.get(posicao++);
    }
}
