package com.rdlts.arcus.ddd.core.domain;

import javax.annotation.Nonnull;

/**
 * DomainEntity 领域实体对象
 * <pre>
 * <ul>
 *  <li><b>有生命周期</b>：实体是领域中具有生命周期的对象，它们存在于一段时间内，并且可以随着时间的推移发生变化。实体可以创建、更新和销毁。</li>
 *  <li><b>唯一标识</b>：实体具有唯一标识，这意味着在整个系统中，每个实体对象都应具有唯一的标识符，
 *  通常是一个ID或者是具有唯一性的属性。这有助于确保不同的实体对象可以被明确定位。</li>
 *  <li><b>与其他实体和值对象的关系</b>：实体可以与其他实体或值对象建立关系，形成复杂的领域模型。这些关系可以通过引用、关联或聚合来表示。</li>
 *  <li><b>行为和业务逻辑</b>：实体不仅包含数据，还包括行为和业务逻辑。实体可以具有方法和操作，用于执行与其相关的业务规则和操作。</li>
 *  <li><b>状态变化</b>：实体可以随时间的推移而发生状态变化，这通常反映了领域内的业务流程和事件。实体的状态变化可以导致触发其他实体的变化或业务规则的执行。</li>
 *  <li><b>事务性操作</b>：实体通常用于表示具有事务性的操作，例如订单、客户、产品等。实体的状态在事务性操作中发生变化，同时可以在持久层中进行数据存储和检索。</li>
 * </ul>
 * </pre>
 * @param <PKType> 唯一主键类型
 * @author wangjialong
 */
@SuppressWarnings("unused")
public interface DomainEntity<PKType> {

    /**
     * 实体唯一主键
     * 通常为资源库生成的随机主键编号，尽量与业务主键分离
     *
     * @return PKType @Nonnull
     */
    @Nonnull
    PKType identity();

    /**
     * 实体版本号，控制更新
     *
     * @see EntityVersion
     * @return EntityVersion
     * @throws UnsupportedOperationException 默认抛出异常，表示未实现版本控制
     */
    @Nonnull
    default EntityVersion version() {
        throw new UnsupportedOperationException("version control not implement!");
    }
}
