package com.test.designpatterns;

/**Facade is a structural design pattern that provides a simplified interface to a library, a framework, 
//or any other complex set of classes.
 * Use the Facade pattern when you need to have a limited but straightforward interface to a complex subsystem.
 * Use the Facade when you want to structure a subsystem into layers.
 * 
 * Pros and Cons
 You can isolate your code from the complexity of a subsystem.
  A facade can become a god object coupled to all classes of an app.
 */

/**
 * The trading facade.
 * <p>
 * Use Case: Imagine a trader has clicked on the Buy button and the Exchange UI component is about
 * to trigger the trade...
 *
 * @author gazbert
 */
public class TradingFacade {

    /**
     * Without this facade, the Exchange UI component would have to know about and call all the different
     * subsystems to execute the trade.... zzzz.... ;-)
     * <p>
     * This example is <em>massively</em> simplified, but you get the idea!
     *
     * @param trade the trade details.
     */
    public void executeBuyOrder(TradeDetails trade) {
        final TradingEngine tradingEngine = new TradingEngine();
        tradingEngine.fillBuyOrder(trade);
        tradingEngine.fillSellOrder(trade);

        final MarketMaker marketMaker = new MarketMaker();
        marketMaker.updateMarketMakingStrategy(trade);

        final ReconciliationSystem recoSystem = new ReconciliationSystem();
        recoSystem.balanceTheExchangeBooks(trade);

        final RiskAndControlSystem riskAndControl = new RiskAndControlSystem();
        riskAndControl.updateClientCreditScore(trade);

        final SettlementSystem settlements = new SettlementSystem();
        settlements.settle(trade);

        final RegulatorySystem regs = new RegulatorySystem();
        regs.auditTrade(trade);

        final SalesAndMarketingSystem sales = new SalesAndMarketingSystem();
        sales.updateCampaignBooks(trade);
    }
}

