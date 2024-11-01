package ch20.oracle.sec12;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;
}
