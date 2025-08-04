package com.rdlts.arcus.ddd.core.domain;

/**
 * 领域聚合根（Aggregate Root）
 * <p>
 * 聚合根是领域驱动设计（DDD）中的核心概念。聚合是一组相关对象的集合，被视为数据修改的一个单元，
 * 聚合根是聚合内部的核心实体，是聚合与外部交互的唯一入口。
 * <ul>
 *   <li>聚合根负责维护聚合内部的一致性，确保业务规则和不变量在聚合生命周期内始终满足。</li>
 *   <li>聚合内的其他实体或值对象只能通过聚合根访问和修改。</li>
 *   <li>聚合根封装了内部状态的修改逻辑，外部只能通过聚合根暴露的方法修改聚合内部状态。</li>
 *   <li>聚合定义了清晰的边界，围绕业务不变量和一致性边界。</li>
 *   <li>每个聚合应独立存在和变化，保持小而简单，避免过度复杂。</li>
 *   <li>聚合根必须是实体</li>
 * </ul>
 * 设计聚合时，选择合适的聚合根非常关键。一个好的聚合根应具备：
 * <ul>
 *   <li>业务概念上的核心实体</li>
 *   <li>能够自然封装聚合的业务规则和不变量</li>
 *   <li>有能力使聚合内部数据的一致性和完整性</li>
 * </ul>
 *
 * @author wangjialong
 * @param <PKType> 实体的唯一主键类型
 */
public interface DomainAggregateRoot<PKType> extends DomainEntity<PKType> {

}
