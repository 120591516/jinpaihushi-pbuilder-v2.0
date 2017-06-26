package com.afocus.pbuilder.common.utils;


/**
 * 扩展的列表接口<br/>
 * 本接口的扩展方法目的在于提高集合操作的易用性，部分方法可能是低效的
 * 
 * @author liuwu
 *
 * @param <T>
 */
public interface List<T> extends java.util.List<T> {

	List<T> subList(int fromIndex, int toIndex);

	default List<T> subList(int fromIndex) {
		return this.subList(fromIndex, this.size());
	}

	default List<T> addAll(int index, T[] arr) {
		for (int i = index; i < arr.length; i++) {
			this.add(arr[i]);
		}
		return this;
	}

	default List<T> addAll(T[] arr) {
		return this.addAll(0, arr);
	}

	default String join(String sp) {
		return this
				.stream()
				.collect(StringBuilder::new,
						(left, right) -> left.append(sp).append(right),
						(left, right) -> left.append(sp).append(right))
				.toString();
	}

	/**
	 * 分组<br/>
	 * 将列表中的元素按原顺序进行分组，每组元素的个数最多为length
	 * 
	 * @param length
	 *            每组元素的长度，不能小于1
	 * @return 分组列表
	 */
//	default List<List<T>> group(final int length) {
//		if (length < 1)
//			throw new IllegalArgumentException("length : " + length);
//		if (this.isEmpty()) {
//			return new ArrayList<>(0);
//		}
//		BiConsumer<List<List<T>>, T> accumulator = (left, right) -> {
//			List<T> temp;
//			if (left.isEmpty()) {
//				temp = new ArrayList<>(length);
//				left.add(temp);
//			} else {
//				List<T> last = left.get(left.size() - 1);
//				if (last.size() < length) {
//					temp = last;
//				} else {
//					temp = new ArrayList<>(length);
//					left.add(temp);
//				}
//			}
//			temp.add(right);
//		};
//		return this.stream().collect(
//				ArrayList::new,
//				accumulator,
//				(left, right) -> {
//					right.forEach(lst -> lst.forEach(e -> accumulator.accept(
//							left, e)));
//				});
//	}

}
