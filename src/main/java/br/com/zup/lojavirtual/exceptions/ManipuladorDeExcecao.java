package br.com.zup.lojavirtual.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ManipuladorDeExcecao extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RespostaDeErro respostaDeErro= new RespostaDeErro(
                "Validação de dados",
                status.value(),
                status.getReasonPhrase(),
                getObjetosDeErro(ex)
        );
        return ResponseEntity.status(status).body(respostaDeErro);
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private List<ObjetoDeErro> getObjetosDeErro(MethodArgumentNotValidException ex) {
        List<ObjetoDeErro> objetoDeErros = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(error -> new ObjetoDeErro(error.getDefaultMessage(), error.getField()))
                .collect(Collectors.toList());
        return objetoDeErros;
    }

    @ExceptionHandler({ProdutoDuplicadoExcecao.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErro produtoDuplicadoExcecao(ProdutoDuplicadoExcecao ex) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                ex.getMessage(),
                ex.getCampo()
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(ex.getTipoErro(), ex.getStatus(), ex.getRazao(), Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }

    @ExceptionHandler({ProdutoListaVaziaExcecao.class})
    @ResponseStatus(HttpStatus.OK)
    public RespostaDeErro produtoListaVaziaExcecao(ProdutoListaVaziaExcecao ex) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                ex.getMessage(),
                ex.getCampo()
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(ex.getTipoErro(), ex.getStatus(), ex.getRazao(), Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }

    @ExceptionHandler({ClienteDuplicadoExcecao.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RespostaDeErro clienteDuplicadoExcecao(ClienteDuplicadoExcecao ex) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                ex.getMessage(),
                ex.getCampo()
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(ex.getTipoErro(), ex.getStatus(), ex.getRazao(), Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }

    @ExceptionHandler({CompraVaziaExcecao.class})
    @ResponseStatus(HttpStatus.OK)
    public RespostaDeErro compraVaziaExcecao(CompraVaziaExcecao ex) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                ex.getMessage(),
                ex.getCampo()
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(ex.getTipoErro(), ex.getStatus(), ex.getRazao(), Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }

    @ExceptionHandler({CompraNaoEncotradaExcecao.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RespostaDeErro compraNaoEncotradaExcecao(CompraNaoEncotradaExcecao ex) {
        ObjetoDeErro objetoDeErro = new ObjetoDeErro(
                ex.getMessage(),
                ex.getCampo()
        );
        RespostaDeErro respostaDeErro = new RespostaDeErro(ex.getTipoErro(), ex.getStatus(), ex.getRazao(), Arrays.asList(objetoDeErro));
        return respostaDeErro;
    }
}
