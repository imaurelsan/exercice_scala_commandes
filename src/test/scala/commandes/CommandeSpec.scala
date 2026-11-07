package commandes

import org.scalatest.funsuite.AnyFunSuite

class CommandeSpec extends AnyFunSuite {
  private val item1 = Item("A1", "Clavier", 20.0)
  private val item2 = Item("A2", "Souris", 10.0)
  private val order = Order("C1", List(item1, item2), None)

  test("calculateTotal retourne zéro pour une commande vide") {
    val emptyOrder = Order("C-vide", Nil, None)
    assert(Commande.calculateTotal(emptyOrder) == 0.0)
  }

  test("calculateTotal additionne plusieurs articles") {
    assert(Commande.calculateTotal(order) == 30.0)
  }

  test("applyDiscount avec un taux de zéro ne change pas les prix") {
    val discounted = Commande.applyDiscount(order, 0.0)
    assert(Commande.calculateTotal(discounted) == 30.0)
  }

  test("applyDiscount avec un taux de 0,5 divise les prix par deux") {
    val discounted = Commande.applyDiscount(order, 0.5)
    assert(Commande.calculateTotal(discounted) == 15.0)
  }

  test("applyDiscount avec un taux de un met les prix à zéro") {
    val discounted = Commande.applyDiscount(order, 1.0)
    assert(Commande.calculateTotal(discounted) == 0.0)
  }

  test("applyDiscount refuse un taux invalide") {
    intercept[IllegalArgumentException](Commande.applyDiscount(order, 1.1))
    intercept[IllegalArgumentException](Commande.applyDiscount(order, -0.1))
  }

  test("processOrders applique la réduction correspondant au code connu") {
    val orderWithCode = order.copy(discountCode = Some("DEMI"))
    assert(Commande.processOrders(List(orderWithCode), Map("DEMI" -> 0.5)) == List(15.0))
  }

  test("processOrders ne réduit pas une commande avec un code inconnu") {
    val orderWithCode = order.copy(discountCode = Some("INCONNU"))
    assert(Commande.processOrders(List(orderWithCode), Map("DEMI" -> 0.5)) == List(30.0))
  }

  test("processOrders ne réduit pas une commande sans code") {
    assert(Commande.processOrders(List(order), Map("DEMI" -> 0.5)) == List(30.0))
  }
}
