
public class JugadorInteligente extends Jugador{	
	
	Tablero tablero;
	Jugador oponente;
	int cantCiclos = 0;	
	private int MAX = 1000;
	private int MIN = -1000;
	JugadorInteligente(char ficha, String nombre) {
		super(ficha, nombre);
		this.tablero = new Tablero(6,7);
		oponente = new Jugador('X',"oponente");
	}


	public int pensarJugada(Tablero tableroAux)
	{
		double modo = 1+ Math.random()*7;
		return (int)modo;
		
		/*
		int columna =0;
		if (!tablero.isFull() && !tablero.existenFichasContiguas(4, this.getFicha()) & !tablero.existenFichasContiguas(4, oponente.getFicha()) )
		{
				
			this.tablero = new Tablero(6,7);
			this.tablero.setTablero(tableroAux.getTablero());
			System.out.println(this.tablero.getFormaDeImpresion());		
			int valor = MIN;
			int aux;
			for(int i=1;i<=this.tablero.getAncho(); i++)
			{
				double modo = 1+ Math.random()*7;
				
				if(tablero.existePosicionVacia((int)modo))
				{
					tablero.setFicha((int)modo, this.getFicha());
					aux = min();					
					if(aux > valor)
					{
						valor = aux;
						columna = i;
					}
					tablero.quitarFicha((int)modo);
				}
			}
		}

		return columna;*/
		
	}
	private int max(){
	
        if (tablero.isFull() || tablero.existenFichasContiguas(4, this.getFicha()) || tablero.existenFichasContiguas(4, oponente.getFicha()) ){
        	
        	if (tablero.existenFichasContiguas(4, this.getFicha())|| tablero.existenFichasContiguas(4, oponente.getFicha()))
        		{
        			
        			return -1;
        		}
            else
            	{
            	 
            		return 0;
            	}
        }
        
        int v=MIN;
        int aux;
        for (int n=1;n<=tablero.getAncho();n++){
           
                if (tablero.existePosicionVacia(n)){
                	
                    tablero.setFicha(n, this.getFicha());
                    if(cantCiclos < 21400)
                    {
                    	cantCiclos++; 
                    	aux=min();
                    if (aux>v)
                    	{
                    		v=aux; 
                    	}
                    }
                    tablero.quitarFicha(n);                  
                }
           
        }
        return v;
        
    }

	private int min(){
	
        if (tablero.isFull() || tablero.existenFichasContiguas(4, this.getFicha()) || tablero.existenFichasContiguas(4, oponente.getFicha()) ){
        	
        	if (tablero.existenFichasContiguas(4, this.getFicha())|| tablero.existenFichasContiguas(4, oponente.getFicha()))
        		{
        		 
        			return 1;
        		}
            else return 0;
        }
      
        int v=MAX;
        int aux;
        for (int n=1;n<=tablero.getAncho();n++){
           
                if (tablero.existePosicionVacia(n)){
                
                    tablero.setFicha(n, oponente.getFicha());                  
                    if(cantCiclos <21400)
                    {
                    	cantCiclos++;
                    	aux=max(); 
                    if (aux<v)
                    	{
                    		v=aux;
                    	}
                    }
                
                    tablero.quitarFicha(n);
                   
                }
           
        }
        
        return v;
        
    }
	



}
