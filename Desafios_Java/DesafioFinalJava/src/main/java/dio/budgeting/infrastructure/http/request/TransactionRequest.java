package dio.budgeting.infrastructure.http.request;

import dio.budgeting.application.input.PersistTransactionInput;
import dio.budgeting.domain.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;

public record TransactionRequest(
    @NotBlank(message = "A descrição não pode estar vazia") 
    String description,
    
    @NotNull(message = "A categoria é obrigatória") 
    Category category,
    
    @NotNull(message = "O valor é obrigatório") 
    @Positive(message = "O valor deve ser maior que zero") 
    Long amount
) {

    public PersistTransactionInput toInput() {
        return new PersistTransactionInput(this.description, this.amount, this.category);
    }
}


