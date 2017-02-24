package com.zero.handsup.common.enums;

/**
 * 数据表字段有效值枚举
 * @author leo.zeng
 */
public interface EffectiveEnums {
	
	/** 数据表中状态字段是否有效枚举 */
	public enum FieldStatusEnum {
		VALID((byte)1),	// 有效
		INVALID((byte)0),	// 无效
		;
		private byte status;
		private FieldStatusEnum(byte stat) {
			this.status = stat;
		}
		public byte getValue() {
			return this.status;
		}
	}
	

}
