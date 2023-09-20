import etoilecraft.*;

public class TestEtoileCraft {
	
	public static void main(String[] args){

		IUnite nwl = new Cuirasse();
		IUnite dal = new Marine();
	
		while((nwl.getPointsDeVie()>0) && (dal.getPointsDeVie()>0)){
	
			System.out.println("Nawal : " + nwl);
			System.out.println("Dalila : " + dal);
			nwl.attaquer(dal);
			dal.attaquer(nwl);
			
		}
		
		System.out.print("Nawal : " + nwl);
		System.out.println("|");
		System.out.println("Dalila : " + dal);
	}
}
