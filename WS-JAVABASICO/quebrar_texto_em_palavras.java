		String texto = "Duas coisas são infinitas: "
				     + "o universo e a estupidez humana. "
					 + "Mas, em relação ao universo, "
					 + "ainda não tenho certeza absoluta";
		
		String[] palavras = texto.split(" ");
		String[] charsARemover = new String[] {",", ".", ":"};
				
		for (String palavra : palavras) {
			for (String charARemover: charsARemover) { 
				palavra = palavra.replace(charARemover, "");
			}
			System.out.println(palavra);
			
		}