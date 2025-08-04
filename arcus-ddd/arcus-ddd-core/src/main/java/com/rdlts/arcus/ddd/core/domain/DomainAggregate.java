package com.rdlts.arcus.ddd.core.domain;

import javax.annotation.Nonnull;

/**
 * 领域聚合概念
 *
 * <pre>
 * <h1>定义：</h1>
 * 聚合是一组相关对象的集合，被视为数据修改的一个单元。在 DDD 中，聚合是数据完整性和业务规则的边界。
 * 每个聚合有一个根和一个边界。聚合根是聚合内的实体，代表整个聚合，是与外部交互的唯一通道。
 * 聚合内的其他对象（实体或值对象）只能通过聚合根访问和修改。
 * 聚合根负责维护聚合内部一致性，确保业务规则和不变量在聚合生命周期内始终满足。
 *
 * <h1>设计原则</h1>
 * <ul>
 *  <li>封装：聚合根封装了内部状态的修改逻辑，外部只能通过聚合根暴露的方法来修改内部状态。</li>
 *  <li>边界明确：聚合定义了清晰的边界，这个边界围绕业务不变量和一致性边界。</li>
 *  <li>独立性：每个聚合应该是独立的，可以独立于其他聚合存在和变化。</li>
 *  <li>大小：应该尽量保持聚合小而简单，只包含必要的实体和值对象，避免过度复杂。</li>
 * </ul>
 *
 * <h1>选择聚合根</h1>
 * 在设计聚合时，选择适当的聚合根非常关键。一个好的聚合根是：
 * <ul>
 *  <li>业务概念上的核心实体。</li>
 *  <li>能够自然地封装聚合的业务规则和不变量。</li>
 *  <li>有足够的信息和能力来确保聚合内部数据的一致性和完整性。</li>
 * </ul>
 * </pre>
 *
 * @author wangjialong
 */
@SuppressWarnings("unused")
public interface DomainAggregate<T extends DomainAggregateRoot<?>> {

    /**
     * 聚合根
     * @return {@link DomainAggregateRoot}
     */
    @Nonnull
    T root();
}
