package br.com.javac.util;  
  
public class ChaveAcessoNFE {  
  
	private String cUF; 			// Código da UF do emitente do Documento Fiscal.  
	private String dataAAMM = ""; 	// Ano e Mês de emissão da NF-e.  
	private String cnpjCpf = ""; 	// CNPJ do emitente.  
	private String mod = ""; 		// Modelo do Documento Fiscal.  
	private String serie = ""; 		// Série do Documento Fiscal.  
	private String tpEmis = ""; 	// Forma de emissão da NF-e  
	private String nNF = ""; 		// Número do Documento Fiscal.  
	private String cNF = ""; 		// Código Numérico que compõe a Chave de Acesso
	private String chaveFinal = "";
    
	public void setcUF(String cUF) {
		this.cUF = cUF;
	}
	public void setDataAAMM(String dataAAMM) {
		this.dataAAMM = dataAAMM;
	}
	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}
	public void setmod(String mod) {
		this.mod = mod;
	}
	public void setserie(String serie) {
		this.serie = serie;
	}
	public void settpEmis(String tpEmis) {
		this.tpEmis = tpEmis;
	}
	public void setnNF(String nNF) {
		this.nNF = nNF;
	}
	public void setcNF(String cNF) {
		this.cNF = cNF;
	}

    public String geraChave() {  
        try {
              
            StringBuilder chave = new StringBuilder();  
            chave.append(lpadTo(this.cUF, 2, '0'));  
            chave.append(lpadTo(this.dataAAMM, 4, '0'));  
            chave.append(lpadTo(this.cnpjCpf.replaceAll("\\D",""), 14, '0'));  
            chave.append(lpadTo(this.mod, 2, '0'));  
            chave.append(lpadTo(this.serie, 3, '0'));  
            chave.append(lpadTo(String.valueOf(this.nNF), 9, '0'));  
            chave.append(lpadTo(this.tpEmis, 1, '0'));  
            chave.append(lpadTo(this.cNF, 8, '0'));  
            chave.append(modulo11(chave.toString()));  
  
            chave.insert(0, "NFe");  
  
            info("Chave NF-e: " + chave.toString());
            this.chaveFinal = chave.toString();
            return this.chaveFinal;
        } catch (Exception e) {  
        	error(e.toString());
            return "Erro";  
        }  
    }  
      
    public static int modulo11(String chave) {  
        int total = 0;  
        int peso = 2;  
              
        for (int i = 0; i < chave.length(); i++) {  
            total += (chave.charAt((chave.length()-1) - i) - '0') * peso;  
            peso ++;  
            if (peso == 10)  
                peso = 2;  
        }  
        int resto = total % 11;  
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);  
    }  
  
    public static String lpadTo(String input, int width, char ch) {  
        String strPad = "";  
  
        StringBuffer sb = new StringBuffer(input.trim());  
        while (sb.length() < width)  
            sb.insert(0,ch);  
        strPad = sb.toString();  
          
        if (strPad.length() > width) {  
            strPad = strPad.substring(0,width);  
        }  
        return strPad;  
    }  
  
    /** 
     * Log ERROR. 
     * @param error 
     */  
    private static void error(String error) {  
        System.out.println("| ERROR: " + error);
    }  
  
    /** 
     * Log INFO. 
     * @param info 
     */  
    private static void info(String info) {  
        System.out.println("| INFO: " + info);  
    }  
  
}