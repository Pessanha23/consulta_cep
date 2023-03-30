package pessanha.consultacep.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("CEP NÃO ENCONTRADO");
    }

}
