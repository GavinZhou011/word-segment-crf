package zx.soft.crf.model;

import java.io.Serializable;
import java.util.StringTokenizer;

public class FeatureIdentifier implements Cloneable, Serializable {

	private static final long serialVersionUID = 4942036159933407311L;

	public int id;
	public Object name;
	public int stateId;

	public FeatureIdentifier() {
	}

	public FeatureIdentifier(int fid, int s, Object n) {
		init(fid, s, n);
	}

	public FeatureIdentifier(String strRep) {
		StringTokenizer strTok = new StringTokenizer(strRep, FileFormat.FEATURE_IDENTIFIER_SEPARATOR);
		name = strTok.nextToken();
		id = Integer.parseInt(strTok.nextToken());
		stateId = Integer.parseInt(strTok.nextToken());
	}

	public void init(int fid, int s, Object n) {
		name = n;
		id = fid;
		stateId = s;
	}

	public void init(int fid) {
		id = fid;
	}

	public void copy(FeatureIdentifier fid) {
		init(fid.id, fid.stateId, fid.name);
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		return (id == ((FeatureIdentifier) o).id);
	}

	public String getName() {
		return name.toString();
	}

	@Override
	public String toString() {
		return name.toString() + FileFormat.FEATURE_IDENTIFIER_SEPARATOR + id + FileFormat.FEATURE_IDENTIFIER_SEPARATOR
				+ stateId;
	}

	@Override
	public Object clone() {
		return new FeatureIdentifier(id, stateId, name);
	}
};
