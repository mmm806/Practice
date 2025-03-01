    package org.example.variousrequestdatapractice.dto;

    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.time.LocalDateTime;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class ErrorResponse {
        private String errorCode;
        private String errorMessage;
        private LocalDateTime timesramp;
    }
