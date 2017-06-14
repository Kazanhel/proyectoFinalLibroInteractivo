package com.denis.mercenario.model;


import com.denis.mercenario.R;

public class Historia {
    private Pagina[] paginas;

    public Historia(){
        paginas = new Pagina[9];

        paginas[0] = new Pagina(R.string.pagina00,
                new Decision(R.string.pagina00_decision1, 1),
                new Decision(R.string.pagina00_decision2, 1),
                new Decision(R.string.pagina00_decision3, 1));

        paginas[1] = new Pagina(R.string.pagina01,
                new Decision(R.string.pagina01_decision1, 2),
                new Decision(R.string.pagina01_decision2, 2),
                new Decision(R.string.pagina01_decision3, 2));

        paginas[2] = new Pagina(R.string.pagina02,
                new Decision(R.string.pagina02_decision1, 3),
                new Decision(R.string.pagina02_decision2, 4),
                new Decision(R.string.pagina02_decision3, 4));

        paginas[3] = new Pagina(R.string.pagina03,
                new Decision(R.string.pagina03_decision1, 7, "sabiduria"),
                new Decision(R.string.pagina03_decision2, 5),
                new Decision(R.string.pagina03_decision3, 5));

        paginas[4] = new Pagina(R.string.pagina04,
                new Decision(R.string.pagina04_decision1, 8, "carisma"),
                new Decision(R.string.pagina04_decision2, 6),
                new Decision(R.string.pagina04_decision3, 6));

        paginas[5] = new Pagina(R.string.pagina05);

        paginas[6] = new Pagina(R.string.pagina06);

        paginas[7] = new Pagina(R.string.pagina07);

        paginas[8] = new Pagina(R.string.pagina08);
    }

    public Pagina getPagina(int numeroPagina) {
        if (numeroPagina >= paginas.length){
            numeroPagina = 0;
        }
        return paginas[numeroPagina];
    }
}
