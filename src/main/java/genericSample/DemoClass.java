package genericSample;

public class DemoClass {
  interface AbstractRidiculousSimpleSuperHandler<MyEvent> {
    void on(MyEvent event);
  }

  static class Karacsony {
    interface Handler extends AbstractRidiculousSimpleSuperHandler<Karacsony> {
    }
  }

  static class Szulinap {
    interface Handler extends AbstractRidiculousSimpleSuperHandler<Szulinap> {
      void on(Szulinap event);
    }
  }

  static class AjandekotKapok {

    class K implements Karacsony.Handler {
      @Override
      public void on(Karacsony event) {
        System.out.println("Karacsony van");
      }
    }

    class S implements Szulinap.Handler {
      @Override
      public void on(Szulinap event) {
        System.out.println("Szulinap van");
      }
    }

    public final K k = new K();
    public final S s = new S();

  }

  public static void main(String[] a) {
    Karacsony karacsony = new Karacsony();
    Szulinap szulinap = new Szulinap();
    AjandekotKapok kezelo = new AjandekotKapok();
    kezelo.k.on(karacsony);
    kezelo.s.on(szulinap);
  }
}
