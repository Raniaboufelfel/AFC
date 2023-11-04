public class App {
    static int n=100;
    static int m=4;
    static int r=2;
    static void Hypothèse_Null(float[] tého){
        System.out.println("\n\n\t\t********   l'hypothèse null  ******** \n\n");
        for(int i=0;i<m;i++){
            tého[i]=n/m;
            System.out.printf("\t%.1f\t", tého[i]);
        }
        System.out.println("\n");
    }
    static void afficher_obse(float[] obs){
        System.out.println("\n\n\t\t********  la table d'observation  ******** \n\n");
        for(int i=0;i<m;i++){
            System.out.printf("\t%.1f\t", obs[i]);
        }
        System.out.println("\n");
    }
    static void represent(float[][] donnee, float[] obs,float[] tého){
        System.out.println("\n\n\t\t********   Représentation des donnee  ******** \n\n");
        for(int j=0;j<r;j++){
            for(int i=0;i<m;i++){
                if(j==0){
                    donnee[j][i]=obs[i];
                }
                else if(j==1){
                    donnee[j][i]=tého[i];
                }
            }
        }
        for(int j=0;j<r;j++){
            for(int i=0;i<m;i++){
                System.out.printf("\t%.1f\t",donnee[j][i]);
            }
            System.out.println("\n");
        }
    }
    static double KHI2(float[][] donnee,double x){
        double[] D= new double[m];
        int k=0;
        System.out.println("\n\n\n\t\t********   KHI_2  ******** \n");
        for(int i=0;i<m;i++){
            D[i]=((donnee[k][i]-donnee[k+1][i])*(donnee[k][i]-donnee[k+1][i]))/donnee[k+1][i];
            x=x+D[i];
        }

        System.out.printf("\n\n\t\t\t KHI_2 = %.2f\n\n",x);
    return x;
    }
    static void degré(float dll){
        System.out.println("\n\n\n\t\t********   degré de liberté  ******** \n");
        dll=(m-1)*(r-1);
        System.out.printf("\n\n\t\t\t dll = %.2f\n\n",dll);
    }
    static void accsOrrej(double x_T,double x_C){
        System.out.println("\n\n\n\t\t**************************** \n");
        if(x_T>x_C){
            System.out.println("\n\n\t l'hypothese null est rejetee \n\n\t il exist un lien entre les facteur\n ");
        }
        else if(x_T<x_C){
            System.out.println("\n\n\t l'hypothese null est accepte \n\n\t n'il exist pas un lien entre les facteur\n\n");
        }
    }
    static void contingence(double x_C,double cont){
        System.out.println("\n\n\n\t\t********   le coefficient de  contigence  ******** \n");
        cont=x_C/(x_C+n);
        cont=Math.sqrt(cont);
        System.out.printf("\n\t\t\tle coefficient de  contigence :  %.4f\n\n",cont);
    }
    public static void main(String[] args) throws Exception {
        float[] tého=new float[m];
        float[] obs={36,34,14,16};
        float[][] donnee= new float[r][m];
        float dll=0;
        double x_C=0;
        double x_T=7.82,cont=0;
        Hypothèse_Null(tého);
        afficher_obse(obs);
        represent(donnee,obs,tého);
        x_C=KHI2(donnee,x_C);
        degré(dll);
        accsOrrej(x_T,x_C);
        contingence(x_C,cont);

    }
    
    
}
